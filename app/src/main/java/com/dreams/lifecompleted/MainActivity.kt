package com.dreams.lifecompleted

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dreams.lifecompleted.ui.theme.LifeCompletedTheme
import org.json.JSONArray
import org.json.JSONObject
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

// ================================
// 1. 全局颜色
// ================================

private val Cream = Color(0xFFFAF7F0)
private val CardWhite = Color(0xFFFFFEFB)
private val Brown = Color(0xFF80664F)
private val DarkBrown = Color(0xFF40362D)
private val LightBrown = Color(0xFFEDE3D5)
private val Muted = Color(0xFF9B9186)
private val Green = Color(0xFF71866B)

// ================================
// 185 项固定人生清单
// ================================

private val FixedLifeItems = listOf(
    "送礼物",
    "被送礼物",
    "暗恋",
    "一个人逛超市",
    "兼职打工",
    "看画展",
    "明恋",
    "失恋",
    "表白",
    "一个人去图书馆",
    "捐款",
    "道歉",
    "释怀",
    "失望",
    "被表白",
    "留长发",
    "剪短发",
    "一个人看病",
    "一个人去唱歌",
    "淋雨",
    "种花",
    "养宠物",
    "染发",
    "漂发",
    "烫发",
    "化妆",
    "社死过",
    "一个人出门逛",
    "泡温泉",
    "跳伞",
    "坐过山车",
    "蹦极",
    "骑马",
    "卡丁车",
    "做美甲",
    "放下一个人",
    "一个人在外难过",
    "有过遗憾",
    "爱而不得",
    "给自己写信",
    "出国",
    "攀岩",
    "游泳",
    "滑雪",
    "滑冰",
    "双向奔赴",
    "当海王",
    "一个人旅游",
    "跟朋友旅游",
    "滑板",
    "去野炊",
    "拒绝他人表白",
    "表白被拒",
    "拥有要好的异性朋友",
    "登山",
    "看雪",
    "看海",
    "看日出",
    "看日落",
    "拿驾照",
    "被渣",
    "犯过傻",
    "装糊涂",
    "谈恋爱",
    "考试不及格",
    "犯校规",
    "迟到",
    "旷课",
    "考试第一名",
    "当班干部",
    "自驾游",
    "给父母买衣服",
    "上课睡觉",
    "打架",
    "被叫家长",
    "竞选学生会",
    "上电视",
    "当伴娘",
    "当伴郎",
    "摆地摊",
    "和朋友去KTV",
    "和同学打水仗",
    "社团活动",
    "去酒吧",
    "上报纸",
    "登台演出",
    "睡一天",
    "失眠",
    "主持节目",
    "演讲",
    "断片",
    "组建社团",
    "写信",
    "野性消费",
    "被雪糕刺客伤过",
    "独自坐飞机",
    "拼拼图",
    "吵架",
    "绝交",
    "晚上一个人哭",
    "献血",
    "被老师点名表扬",
    "办生日会",
    "健身",
    "买名牌",
    "被老师点名批评",
    "全校表扬",
    "住院",
    "做手术",
    "晕倒",
    "开网店",
    "练字",
    "沉迷游戏",
    "做一桌菜",
    "会做饭",
    "被背叛",
    "被伤害",
    "拍毕业照",
    "面试成功",
    "做饭给家人",
    "被坚定选择",
    "获奖",
    "放孔明灯",
    "逛小吃街",
    "做甜品给喜欢的人",
    "学一种外语",
    "写论文",
    "和网友见面",
    "发表成果",
    "有超过10年的好朋友",
    "买唱片",
    "异地恋",
    "异国恋",
    "写书",
    "写诗",
    "写日记",
    "有个无条件可信任的朋友",
    "写剧本",
    "写歌",
    "拍影片",
    "认识不同国籍的人",
    "创业",
    "买花",
    "被送花",
    "参加比赛",
    "拍写真",
    "看极光",
    "进公司工作",
    "给自己买礼物",
    "通宵补作业",
    "买相机",
    "会一种乐器",
    "做未来规划",
    "搬家",
    "一个人散步",
    "有过超过5年的兴趣爱好",
    "夜跑",
    "一个人租房",
    "转学",
    "被骗",
    "参加志愿活动",
    "撒谎",
    "改掉一个坏习惯",
    "深夜散心",
    "自己一个人住宾馆",
    "看鬼片",
    "向陌生人吐露心声",
    "加入校队",
    "坐摩天轮",
    "一个人出去吃饭",
    "去密室",
    "在朋友家过夜",
    "去鬼屋",
    "去看现场演唱会",
    "擅长一项运动",
    "一个人看电影",
    "摄影",
    "去游乐场",
    "去音乐节",
    "谈过一场刻骨铭心的恋爱",
    "一个人去酒吧",
    "偶遇明星",
    "去签售会",
    "在图书馆待一天",
    "一个人过生日"
)

// 检查固定清单数量和重复项
private val fixedLifeItemsCheck = run {
    check(FixedLifeItems.size == 185) {
        "固定清单数量错误：${FixedLifeItems.size}"
    }

    check(FixedLifeItems.distinct().size == 185) {
        "固定清单存在重复事项"
    }
}

// 固定清单独立存储，不影响自定义人生经历
private const val FIXED_DONE_KEY = "fixed_completed_items"

private fun loadFixedDone(context: Context): Set<String> {
    return context.getSharedPreferences(
        PREF_NAME,
        Context.MODE_PRIVATE
    ).getStringSet(FIXED_DONE_KEY, emptySet())
        ?.toSet() ?: emptySet()
}

private fun saveFixedDone(
    context: Context,
    completed: Set<String>
) {
    context.getSharedPreferences(
        PREF_NAME,
        Context.MODE_PRIVATE
    ).edit()
        .putStringSet(FIXED_DONE_KEY, completed.toSet())
        .apply()
}

// ================================
// 2. 数据模型
// ================================

data class LifeItem(
    val id: Long,
    val title: String,
    val description: String,
    val category: String,
    val date: String,
    val isCompleted: Boolean,
    val createdAt: Long
)

private fun currentDate(): String {
    return SimpleDateFormat(
        "yyyy-MM-dd",
        Locale.getDefault()
    ).format(Date())
}

// ================================
// 3. 本地数据存储
// ================================

private const val PREF_NAME = "life_completed_data"
private const val DATA_KEY = "life_items"

private fun loadItems(context: Context): List<LifeItem> {
    return try {
        val prefs = context.getSharedPreferences(
            PREF_NAME,
            Context.MODE_PRIVATE
        )

        val json = prefs.getString(DATA_KEY, "[]")
            ?: "[]"

        val array = JSONArray(json)

        (0 until array.length()).map { index ->
            val obj = array.getJSONObject(index)

            LifeItem(
                id = obj.getLong("id"),
                title = obj.getString("title"),
                description = obj.optString("description"),
                category = obj.optString("category"),
                date = obj.optString("date"),
                isCompleted = obj.optBoolean("isCompleted"),
                createdAt = obj.optLong("createdAt")
            )
        }
    } catch (e: Exception) {
        emptyList()
    }
}

private fun itemsToJson(items: List<LifeItem>): String {
    val array = JSONArray()

    items.forEach { item ->
        val obj = JSONObject().apply {
            put("id", item.id)
            put("title", item.title)
            put("description", item.description)
            put("category", item.category)
            put("date", item.date)
            put("isCompleted", item.isCompleted)
            put("createdAt", item.createdAt)
        }

        array.put(obj)
    }

    return array.toString(2)
}

private fun parseBackup(json: String): List<LifeItem> {
    val array = JSONArray(json)

    return (0 until array.length()).map { index ->
        val obj = array.getJSONObject(index)

        LifeItem(
            id = obj.getLong("id"),
            title = obj.getString("title"),
            description = obj.optString("description"),
            category = obj.optString("category"),
            date = obj.optString("date"),
            isCompleted = obj.optBoolean("isCompleted"),
            createdAt = obj.optLong("createdAt")
        )
    }
}

private fun saveItems(
    context: Context,
    items: List<LifeItem>
) {
    context.getSharedPreferences(
        PREF_NAME,
        Context.MODE_PRIVATE
    ).edit()
        .putString(DATA_KEY, itemsToJson(items))
        .apply()
}

// ================================
// 4. 页面导航
// ================================

private enum class AppPage(
    val label: String,
    val symbol: String
) {
    HOME("首页", "⌂"),
    LIST("清单", "☷"),
    GOALS("目标", "☆"),
    MINE("我的", "●")
}

// ================================
// 5. Activity
// ================================

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            LifeCompletedTheme {
                LifeApp()
            }
        }
    }
}

// ================================
// 6. App 主界面
// ================================

@Composable
fun LifeApp() {

    val context = LocalContext.current

    var lifeItems by remember {
        mutableStateOf(loadItems(context))
    }

    // 185 项固定清单的已完成记录
    var fixedCompleted by remember {
        mutableStateOf(loadFixedDone(context))
    }

    // 自动保存固定清单状态
    LaunchedEffect(fixedCompleted) {
        saveFixedDone(context, fixedCompleted)
    }

    var currentPage by remember {
        mutableStateOf(AppPage.HOME)
    }

    var showAddDialog by remember {
        mutableStateOf(false)
    }

    var editingItem by remember {
        mutableStateOf<LifeItem?>(null)
    }

    // 数据发生变化时自动保存
    LaunchedEffect(lifeItems) {
        saveItems(context, lifeItems)
    }

    // 导出备份
    val exportLauncher =
        rememberLauncherForActivityResult(
            ActivityResultContracts.CreateDocument(
                "application/json"
            )
        ) { uri: Uri? ->

            if (uri != null) {
                try {
                    context.contentResolver
                        .openOutputStream(uri)
                        ?.use { output ->
                            output.write(
                                itemsToJson(lifeItems).toByteArray()
                            )
                        }

                    Toast.makeText(
                        context,
                        "备份导出成功",
                        Toast.LENGTH_SHORT
                    ).show()

                } catch (e: Exception) {
                    Toast.makeText(
                        context,
                        "导出失败：${e.message}",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }

    // 导入备份
    val importLauncher =
        rememberLauncherForActivityResult(
            ActivityResultContracts.OpenDocument()
        ) { uri: Uri? ->

            if (uri != null) {
                try {
                    val json = context.contentResolver
                        .openInputStream(uri)
                        ?.bufferedReader()
                        ?.use { it.readText() }
                        ?: throw Exception("无法读取文件")

                    val importedItems = parseBackup(json)

                    lifeItems = importedItems

                    Toast.makeText(
                        context,
                        "成功导入 ${importedItems.size} 条记录",
                        Toast.LENGTH_SHORT
                    ).show()

                } catch (e: Exception) {
                    Toast.makeText(
                        context,
                        "备份文件无效：${e.message}",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }

    val completedCount = lifeItems.count {
        it.isCompleted
    }

    val pendingCount = lifeItems.size - completedCount

    Scaffold(
        containerColor = Cream,

        bottomBar = {
            NavigationBar(
                containerColor = CardWhite,
                contentColor = Brown
            ) {
                AppPage.entries.forEach { page ->

                    NavigationBarItem(
                        selected = currentPage == page,
                        onClick = {
                            currentPage = page
                        },
                        icon = {
                            Text(
                                page.symbol,
                                fontSize = 22.sp
                            )
                        },
                        label = {
                            Text(page.label)
                        },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = Brown,
                            selectedTextColor = Brown,
                            indicatorColor = LightBrown,
                            unselectedIconColor = Muted,
                            unselectedTextColor = Muted
                        )
                    )
                }
            }
        },

        floatingActionButton = {
            if (currentPage != AppPage.MINE) {
                FloatingActionButton(
                    onClick = {
                        editingItem = null
                        showAddDialog = true
                    },
                    containerColor = Brown,
                    contentColor = Color.White,
                    shape = RoundedCornerShape(18.dp)
                ) {
                    Text("+", fontSize = 28.sp)
                }
            }
        }

    ) { padding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {

            when (currentPage) {

                AppPage.HOME -> {
                    HomeScreen(
                        items = lifeItems,
                        completedCount = completedCount,
                        pendingCount = pendingCount,
                        onItemClick = {
                            editingItem = it
                            showAddDialog = true
                        }
                    )
                }

                AppPage.LIST -> {
                    ListScreen(
                        items = lifeItems,
                        onItemClick = {
                            editingItem = it
                            showAddDialog = true
                        },
                        onToggle = { item ->
                            lifeItems = lifeItems.map {
                                if (it.id == item.id) {
                                    it.copy(
                                        isCompleted = !it.isCompleted
                                    )
                                } else it
                            }
                        }
                    )
                }

                AppPage.GOALS -> {
                    GoalsScreen(
                        completedItems = fixedCompleted,
                        onToggle = { item ->
                            fixedCompleted = if (item in fixedCompleted) {
                                fixedCompleted - item
                            } else {
                                fixedCompleted + item
                            }
                        }
                    )
                }

                AppPage.MINE -> {
                    MineScreen(
                        total = lifeItems.size,
                        completed = completedCount,
                        pending = pendingCount,
                        onExport = {
                            exportLauncher.launch(
                                "LifeCompleted_Backup.json"
                            )
                        },
                        onImport = {
                            importLauncher.launch(
                                arrayOf(
                                    "application/json",
                                    "text/plain",
                                    "*/*"
                                )
                            )
                        }
                    )
                }
            }
        }
    }

    // 新增或编辑窗口
    if (showAddDialog) {

        ItemEditDialog(
            item = editingItem,

            onDismiss = {
                showAddDialog = false
                editingItem = null
            },

            onSave = { newItem ->

                lifeItems = if (editingItem == null) {
                    lifeItems + newItem
                } else {
                    lifeItems.map {
                        if (it.id == newItem.id) newItem
                        else it
                    }
                }

                showAddDialog = false
                editingItem = null
            },

            onDelete = { item ->
                lifeItems = lifeItems.filter {
                    it.id != item.id
                }

                showAddDialog = false
                editingItem = null
            }
        )
    }
}

// ================================
// 7. 首页
// ================================

@Composable
fun HomeScreen(
    items: List<LifeItem>,
    completedCount: Int,
    pendingCount: Int,
    onItemClick: (LifeItem) -> Unit
) {

    val rate = if (items.isEmpty()) {
        0
    } else {
        completedCount * 100 / items.size
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp)
    ) {

        Spacer(Modifier.height(24.dp))

        Text(
            "MY LIFE JOURNEY",
            color = Brown,
            fontSize = 12.sp,
            letterSpacing = 2.sp
        )

        Spacer(Modifier.height(8.dp))

        Text(
            "我的人生",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = DarkBrown
        )

        Text(
            "记录已经走过的路，也期待未来。",
            color = Muted,
            fontSize = 14.sp
        )

        Spacer(Modifier.height(24.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = LightBrown
            ),
            shape = RoundedCornerShape(24.dp)
        ) {
            Column(
                modifier = Modifier.padding(24.dp)
            ) {

                Text(
                    "已经完成的人生经历",
                    color = Brown,
                    fontSize = 14.sp
                )

                Spacer(Modifier.height(8.dp))

                Row(
                    verticalAlignment = Alignment.Bottom
                ) {
                    Text(
                        completedCount.toString(),
                        fontSize = 54.sp,
                        fontWeight = FontWeight.Bold,
                        color = DarkBrown
                    )

                    Spacer(Modifier.width(8.dp))

                    Text(
                        "件",
                        color = Brown,
                        modifier = Modifier.padding(bottom = 10.dp)
                    )
                }

                HorizontalDivider(
                    color = Brown.copy(alpha = 0.2f)
                )

                Spacer(Modifier.height(16.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    StatText("未完成目标", pendingCount.toString())
                    StatText("完成率", "$rate%")
                    StatText("全部记录", items.size.toString())
                }
            }
        }

        Spacer(Modifier.height(28.dp))

        Text(
            "最近完成",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = DarkBrown
        )

        Spacer(Modifier.height(12.dp))

        val recentItems = items
            .filter { it.isCompleted }
            .sortedByDescending { it.date }
            .take(5)

        if (recentItems.isEmpty()) {
            EmptyState(
                "还没有完成的事情",
                "每一段经历，都值得被记录。"
            )
        } else {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                items(recentItems, key = { it.id }) { item ->
                    ItemCard(
                        item = item,
                        onClick = {
                            onItemClick(item)
                        }
                    )
                }
            }
        }
    }
}

@Composable
private fun StatText(
    label: String,
    value: String
) {
    Column {
        Text(
            value,
            fontSize = 21.sp,
            fontWeight = FontWeight.Bold,
            color = DarkBrown
        )

        Text(
            label,
            fontSize = 12.sp,
            color = Brown
        )
    }
}

// ================================
// 8. 全部清单
// ================================

@Composable
fun ListScreen(
    items: List<LifeItem>,
    onItemClick: (LifeItem) -> Unit,
    onToggle: (LifeItem) -> Unit
) {

    var filter by remember {
        mutableStateOf("全部")
    }

    val filteredItems = when (filter) {
        "已完成" -> items.filter { it.isCompleted }
        "未完成" -> items.filter { !it.isCompleted }
        else -> items
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp)
    ) {

        Spacer(Modifier.height(24.dp))

        Text(
            "我的清单",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = DarkBrown
        )

        Text(
            "所有值得记录的人生经历",
            color = Muted,
            fontSize = 14.sp
        )

        Spacer(Modifier.height(20.dp))

        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            listOf("全部", "未完成", "已完成").forEach { option ->

                FilterChip(
                    selected = filter == option,
                    onClick = {
                        filter = option
                    },
                    label = {
                        Text(option)
                    },
                    colors = FilterChipDefaults.filterChipColors(
                        selectedContainerColor = LightBrown,
                        selectedLabelColor = DarkBrown
                    )
                )
            }
        }

        Spacer(Modifier.height(12.dp))

        if (filteredItems.isEmpty()) {
            EmptyState(
                "这里还没有记录",
                "点击右下角 + 添加人生经历。"
            )
        } else {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(10.dp),
                contentPadding = PaddingValues(bottom = 20.dp)
            ) {
                items(
                    filteredItems.sortedByDescending { it.date },
                    key = { it.id }
                ) { item ->

                    Column {
                        ItemCard(
                            item = item,
                            onClick = {
                                onItemClick(item)
                            }
                        )

                        TextButton(
                            onClick = {
                                onToggle(item)
                            }
                        ) {
                            Text(
                                if (item.isCompleted) {
                                    "重新设为未完成"
                                } else {
                                    "标记为已完成 ✓"
                                },
                                color = Brown
                            )
                        }
                    }
                }
            }
        }
    }
}

// ================================
//  人生目标
// 9. 固定人生清单页面
// ================================

@Composable
fun GoalsScreen(
    completedItems: Set<String>,
    onToggle: (String) -> Unit
) {

    var filter by remember {
        mutableStateOf("全部")
    }

    var searchText by remember {
        mutableStateOf("")
    }

    val completedCount = completedItems.size

    val pendingCount =
        FixedLifeItems.size - completedCount


    val filteredItems = remember(
        filter,
        searchText,
        completedItems
    ) {

        FixedLifeItems.filter { item ->

            val matchFilter = when (filter) {
                "已完成" -> item in completedItems
                "未完成" -> item !in completedItems
                else -> true
            }

            val matchSearch =
                searchText.isBlank() ||
                        item.contains(
                            searchText.trim(),
                            ignoreCase = true
                        )

            matchFilter && matchSearch
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Cream)
            .padding(horizontal = 18.dp)
    ) {

        Spacer(Modifier.height(20.dp))

        // 标题
        Text(
            "人生已完成清单",
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            color = DarkBrown
        )

        Spacer(Modifier.height(5.dp))

        Text(
            "记录人生中值得珍藏的每一次经历",
            fontSize = 13.sp,
            color = Muted
        )

        Spacer(Modifier.height(18.dp))

        // 完成统计卡片
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(22.dp),
            colors = CardDefaults.cardColors(
                containerColor = LightBrown
            )
        ) {

            Column(
                modifier = Modifier.padding(18.dp)
            ) {

                Row(
                    verticalAlignment = Alignment.Bottom
                ) {

                    Text(
                        "已完成",
                        color = Brown,
                        fontSize = 15.sp
                    )

                    Spacer(Modifier.width(10.dp))

                    Text(
                        "$completedCount",
                        color = DarkBrown,
                        fontSize = 34.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        " / ${FixedLifeItems.size}",
                        color = Brown,
                        fontSize = 18.sp,
                        modifier = Modifier.padding(
                            bottom = 5.dp
                        )
                    )

                    Spacer(Modifier.weight(1f))

                    Text(
                        "${completedCount * 100 / FixedLifeItems.size}%",
                        color = Brown,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                }

                Spacer(Modifier.height(12.dp))

                LinearProgressIndicator(
                    progress = {
                        completedCount.toFloat() /
                                FixedLifeItems.size
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(9.dp),
                    color = Green,
                    trackColor = Color(0xFFD8CABB),
                    strokeCap = androidx.compose.ui.graphics.StrokeCap.Round
                )

                Spacer(Modifier.height(10.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Text(
                        "已完成 $completedCount 项",
                        color = Brown,
                        fontSize = 12.sp
                    )

                    Text(
                        "还剩 $pendingCount 项",
                        color = Brown,
                        fontSize = 12.sp
                    )
                }
            }
        }

        Spacer(Modifier.height(16.dp))

        // 搜索框
        OutlinedTextField(
            value = searchText,
            onValueChange = {
                searchText = it
            },
            modifier = Modifier.fillMaxWidth(),
            placeholder = {
                Text("搜索人生经历...")
            },
            singleLine = true,
            shape = RoundedCornerShape(14.dp)
        )

        Spacer(Modifier.height(12.dp))

        // 筛选按钮
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            listOf(
                "全部" to FixedLifeItems.size,
                "已完成" to completedCount,
                "未完成" to pendingCount
            ).forEach { (name, count) ->

                FilterChip(
                    selected = filter == name,
                    onClick = {
                        filter = name
                    },
                    label = {
                        Text("$name $count")
                    },
                    colors = FilterChipDefaults.filterChipColors(
                        selectedContainerColor = LightBrown,
                        selectedLabelColor = DarkBrown
                    )
                )
            }
        }

        Spacer(Modifier.height(10.dp))

        Text(
            "点击事项即可打卡，再次点击可取消",
            fontSize = 12.sp,
            color = Muted
        )

        Spacer(Modifier.height(10.dp))

        // 固定清单
        LazyColumn(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(bottom = 20.dp)
        ) {

            items(
                filteredItems,
                key = { it }
            ) { item ->

                val isCompleted =
                    item in completedItems

                Card(
                    onClick = {
                        onToggle(item)
                    },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(13.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = if (isCompleted) {
                            Color(0xFFE5EBDD)
                        } else {
                            CardWhite
                        }
                    ),
                    border = androidx.compose.foundation.BorderStroke(
                        1.dp,
                        if (isCompleted) {
                            Green.copy(alpha = 0.35f)
                        } else {
                            LightBrown
                        }
                    )
                ) {

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(
                                horizontal = 13.dp,
                                vertical = 14.dp
                            ),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        // 完成状态图标
                        Box(
                            modifier = Modifier
                                .size(23.dp)
                                .background(
                                    color = if (isCompleted) {
                                        Green
                                    } else {
                                        Color.Transparent
                                    },
                                    shape = RoundedCornerShape(50)
                                ),
                            contentAlignment = Alignment.Center
                        ) {

                            if (isCompleted) {
                                Text(
                                    "✓",
                                    color = Color.White,
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            } else {
                                Box(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .padding(2.dp)
                                        .background(
                                            CardWhite,
                                            RoundedCornerShape(50)
                                        )
                                )

                                androidx.compose.foundation.Canvas(
                                    modifier = Modifier.fillMaxSize()
                                ) {
                                    drawCircle(
                                        color = Brown.copy(alpha = 0.5f),
                                        style = androidx.compose.ui.graphics.drawscope.Stroke(
                                            width = 2.dp.toPx()
                                        )
                                    )
                                }
                            }
                        }

                        Spacer(Modifier.width(12.dp))

                        Text(
                            text = item,
                            modifier = Modifier.weight(1f),
                            color = if (isCompleted) {
                                Green
                            } else {
                                DarkBrown
                            },
                            fontSize = 14.sp,
                            fontWeight = if (isCompleted) {
                                FontWeight.Medium
                            } else {
                                FontWeight.Normal
                            }
                        )

                        if (isCompleted) {
                            Text(
                                "已完成",
                                color = Green,
                                fontSize = 11.sp
                            )
                        }
                    }
                }
            }

            if (filteredItems.isEmpty()) {
                item {
                    EmptyState(
                        "没有找到相关事项",
                        "试试其他关键词或筛选条件。"
                    )
                }
            }
        }
    }
}

// ================================
// 10. 我的
// ================================

@Composable
fun MineScreen(
    total: Int,
    completed: Int,
    pending: Int,
    onExport: () -> Unit,
    onImport: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {

        Spacer(Modifier.height(24.dp))

        Text(
            "我的",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = DarkBrown
        )

        Spacer(Modifier.height(20.dp))

        Card(
            colors = CardDefaults.cardColors(
                containerColor = CardWhite
            ),
            shape = RoundedCornerShape(22.dp)
        ) {
            Column(
                modifier = Modifier.padding(20.dp)
            ) {

                Text(
                    "人生数据统计",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = DarkBrown
                )

                Spacer(Modifier.height(20.dp))

                StatText("全部记录", total.toString())

                Spacer(Modifier.height(12.dp))

                StatText("已完成", completed.toString())

                Spacer(Modifier.height(12.dp))

                StatText("未完成", pending.toString())
            }
        }

        Spacer(Modifier.height(24.dp))

        Text(
            "数据管理",
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            color = DarkBrown
        )

        Spacer(Modifier.height(12.dp))

        Button(
            onClick = onExport,
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Brown
            ),
            shape = RoundedCornerShape(14.dp)
        ) {
            Text("导出人生记录 JSON 备份")
        }

        OutlinedButton(
            onClick = onImport,
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.outlinedButtonColors(
                contentColor = Brown
            ),
            shape = RoundedCornerShape(14.dp)
        ) {
            Text("从 JSON 文件导入备份")
        }

        Spacer(Modifier.height(28.dp))

        Text(
            "LIFE COMPLETED",
            color = Brown,
            fontWeight = FontWeight.Bold,
            letterSpacing = 2.sp
        )

        Text(
            "人生是一场持续完成的旅程。",
            color = Muted,
            fontSize = 13.sp
        )

        Spacer(Modifier.height(12.dp))

        Text(
            "Version 1.0.0",
            color = Muted,
            fontSize = 12.sp
        )
    }
}

// ================================
// 11. 记录卡片
// ================================

@Composable
fun ItemCard(
    item: LifeItem,
    onClick: () -> Unit
) {

    Card(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = CardWhite
        ),
        shape = RoundedCornerShape(18.dp)
    ) {

        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                if (item.isCompleted) "✓" else "☆",
                color = if (item.isCompleted) Green else Brown,
                fontSize = 24.sp
            )

            Spacer(Modifier.width(12.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {

                Text(
                    item.title,
                    color = DarkBrown,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                Spacer(Modifier.height(4.dp))

                Text(
                    "${item.category} · ${item.date}",
                    color = Muted,
                    fontSize = 12.sp
                )

                if (item.description.isNotBlank()) {
                    Spacer(Modifier.height(5.dp))

                    Text(
                        item.description,
                        color = Brown,
                        fontSize = 13.sp,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
        }
    }
}

// ================================
// 12. 空状态
// ================================

@Composable
fun EmptyState(
    title: String,
    subtitle: String
) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 45.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            "✧",
            color = Brown,
            fontSize = 42.sp
        )

        Spacer(Modifier.height(12.dp))

        Text(
            title,
            color = DarkBrown,
            fontWeight = FontWeight.Bold
        )

        Spacer(Modifier.height(6.dp))

        Text(
            subtitle,
            color = Muted,
            fontSize = 13.sp
        )
    }
}

// ================================
// 13. 新增 / 编辑记录
// ================================

@Composable
fun ItemEditDialog(
    item: LifeItem?,
    onDismiss: () -> Unit,
    onSave: (LifeItem) -> Unit,
    onDelete: (LifeItem) -> Unit
) {

    var title by remember(item) {
        mutableStateOf(item?.title ?: "")
    }

    var description by remember(item) {
        mutableStateOf(item?.description ?: "")
    }

    var category by remember(item) {
        mutableStateOf(item?.category ?: "生活")
    }

    var date by remember(item) {
        mutableStateOf(item?.date ?: currentDate())
    }

    var completed by remember(item) {
        mutableStateOf(item?.isCompleted ?: false)
    }

    var error by remember {
        mutableStateOf(false)
    }

    AlertDialog(
        onDismissRequest = onDismiss,

        containerColor = Cream,

        title = {
            Text(
                if (item == null) "记录一件人生经历"
                else "编辑人生记录",
                color = DarkBrown,
                fontWeight = FontWeight.Bold
            )
        },

        text = {

            Column(
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {

                OutlinedTextField(
                    value = title,
                    onValueChange = {
                        title = it
                        error = false
                    },
                    label = {
                        Text("事项名称 *")
                    },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth()
                )

                OutlinedTextField(
                    value = description,
                    onValueChange = {
                        description = it
                    },
                    label = {
                        Text("描述 / 心情")
                    },
                    modifier = Modifier.fillMaxWidth(),
                    minLines = 2,
                    maxLines = 4
                )

                OutlinedTextField(
                    value = category,
                    onValueChange = {
                        category = it
                    },
                    label = {
                        Text("分类")
                    },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth()
                )

                OutlinedTextField(
                    value = date,
                    onValueChange = {
                        date = it
                    },
                    label = {
                        Text("日期（YYYY-MM-DD）")
                    },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth()
                )

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Text(
                        "已经完成",
                        color = DarkBrown,
                        modifier = Modifier.weight(1f)
                    )

                    Switch(
                        checked = completed,
                        onCheckedChange = {
                            completed = it
                        }
                    )
                }

                if (error) {
                    Text(
                        "请输入事项名称",
                        color = MaterialTheme.colorScheme.error,
                        fontSize = 12.sp
                    )
                }
            }
        },

        confirmButton = {
            TextButton(
                onClick = {

                    if (title.isBlank()) {
                        error = true
                    } else {

                        val newItem = LifeItem(
                            id = item?.id
                                ?: System.currentTimeMillis(),
                            title = title.trim(),
                            description = description.trim(),
                            category = category.trim()
                                .ifBlank { "生活" },
                            date = date.trim()
                                .ifBlank { currentDate() },
                            isCompleted = completed,
                            createdAt = item?.createdAt
                                ?: System.currentTimeMillis()
                        )

                        onSave(newItem)
                    }
                }
            ) {
                Text("保存", color = Brown)
            }
        },

        dismissButton = {

            Row {

                if (item != null) {
                    TextButton(
                        onClick = {
                            onDelete(item)
                        }
                    ) {
                        Text(
                            "删除",
                            color = Color(0xFFB45C50)
                        )
                    }
                }

                TextButton(
                    onClick = onDismiss
                ) {
                    Text("取消", color = Muted)
                }
            }
        }
    )
}