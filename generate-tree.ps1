```powershell
# ============================================
# Recursive Directory Tree Generator
# Windows PowerShell
# ============================================

$RootPath = Split-Path -Parent $MyInvocation.MyCommand.Path
$OutputFile = Join-Path $RootPath "directory-tree.txt"

# Directories to exclude
$ExcludeDirectories = @(
    ".git",
    ".gradle",
    ".idea",
    "build",
    "captures",
    ".cxx",
    ".externalNativeBuild"
)

# Files to exclude
$ExcludeFiles = @(
    "directory-tree.txt"
)

$Output = New-Object System.Collections.Generic.List[string]

function Write-Tree {
    param (
        [string]$Path,
        [string]$Prefix
    )

    try {
        $Items = @(Get-ChildItem -LiteralPath $Path -Force -ErrorAction Stop |
            Where-Object {
                if ($_.PSIsContainer) {
                    $_.Name -notin $ExcludeDirectories
                }
                else {
                    $_.Name -notin $ExcludeFiles
                }
            } |
            Sort-Object `
                @{Expression = {$_.PSIsContainer}; Descending = $true},
                @{Expression = {$_.Name}; Descending = $false})
    }
    catch {
        $Output.Add("$Prefix[ACCESS DENIED] $Path")
        return
    }

    for ($i = 0; $i -lt $Items.Count; $i++) {

        $Item = $Items[$i]

        if ($i -eq $Items.Count - 1) {
            $Branch = "\-- "
            $NextPrefix = "$Prefix    "
        }
        else {
            $Branch = "|-- "
            $NextPrefix = "$Prefix|   "
        }

        $Output.Add("$Prefix$Branch$($Item.Name)")

        if ($Item.PSIsContainer) {
            Write-Tree `
                -Path $Item.FullName `
                -Prefix $NextPrefix
        }
    }
}

# Root directory
$RootName = Split-Path $RootPath -Leaf

if ([string]::IsNullOrWhiteSpace($RootName)) {
    $RootName = $RootPath
}

$Output.Add($RootName)

# Generate tree
Write-Tree -Path $RootPath -Prefix ""

# Write UTF-8 output
$Output | Set-Content -LiteralPath $OutputFile -Encoding UTF8

Write-Host ""
Write-Host "============================================" -ForegroundColor Cyan
Write-Host "Directory tree generated successfully." -ForegroundColor Green
Write-Host "============================================" -ForegroundColor Cyan
Write-Host ""
Write-Host "Root:" -ForegroundColor Yellow
Write-Host $RootPath
Write-Host ""
Write-Host "Output:" -ForegroundColor Yellow
Write-Host $OutputFile
Write-Host ""
Write-Host "Press Enter to exit..." -ForegroundColor Cyan

Read-Host
```