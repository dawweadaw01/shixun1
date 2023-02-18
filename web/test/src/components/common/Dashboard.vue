<template>
	<div class="home">
		<div class="stat">
			<!--用户卡片-->
			<div class="stat-user">
				<div class="stat-user__title">SFAC Admin</div>
				<div class="stat-user__detail">
					<p>欢迎您，{{ user.userName | upperCaseFirst }}</p>
					<p>当前时间：{{ nowTime }}</p>
				</div>
				<img class="stat-user__portrait" :src="user.userImage" alt="" />
			</div>
			<!--系统统计数据概览-->
			<div class="stat-info">
				<el-row :gutter="20" v-for="(info, index) in starData" :key="index">
					<el-col :span="8" v-for="(item, index) in info" :key="index">
						<div class="stat-info__item">
							<div class="stat-info__icon" :style="{ 'background-color': item.bgColor }">
								<i :class="item.icon"></i>
							</div>
							<div class="stat-info__detail">
								<span class="stat-info__total">{{ item.total }}</span>
								<span class="stat-info__title">{{ item.title }}</span>
							</div>
						</div>
					</el-col>
				</el-row>
			</div>
		</div>
		<el-row :gutter="20" class="margin-t-20 list">
			<!--待办事项-->
			<el-col :span="12">
				<el-card>
					<div slot="header">
						<span><i class="el-icon-tickets margin-r-5"></i>待办事项</span>
						<i class="el-icon-plus" @click="addNewTodoItem" title="新增"></i>
					</div>
					<p v-for="(item, i) in todoList" :key="i">
						<el-checkbox v-model="item.isChecked"></el-checkbox>
						<span :class="{ active: item.isChecked }"
							>{{ i + 1 > 9 ? i + 1 : "0" + (i + 1) }}-{{ item.title }}</span
						>
					</p>
					<div>
						<i class="el-icon-more" title="更多"></i>
					</div>
				</el-card>
			</el-col>
			<!--最新消息-->
			<el-col :span="12">
				<el-card>
					<div slot="header">
						<span><i class="el-icon-news margin-r-5"></i>最新消息</span>
					</div>
					<p v-for="(item, i) in latestNewList" :key="i">
						<span class="latest-new-list__time"
							><i class="el-icon-time margin-r-5"></i>{{ item.time }}：</span
						>
						<span>{{ item.title }}</span>
					</p>
					<div>
						<i class="el-icon-more" title="更多"></i>
					</div>
				</el-card>
			</el-col>
		</el-row>
	</div>
</template>

<script>
export default {
	name: "Dashboard",
	props: {
		user: { type: Object },
	},
	data: function () {
		return {
			nowTime: new Date().Format("yyyy-MM-dd hh:mm:ss"),
			starData: this.$TestData.starData,
			todoList: this.$TestData.todoList,
			latestNewList: this.$TestData.latestNewList,
		};
	},
	methods: {
		setNowTime: function () {
			// 周期执行
			setInterval(() => {
				this.nowTime = new Date().Format("yyyy-MM-dd hh:mm:ss");
			}, 1000);
		},
		addNewTodoItem: function () {
			this.$prompt("请输入待办事项主题", "新增待办事项", {
				confirmButtonText: "确定",
				cancelButtonText: "取消",
			})
				.then(({ value }) => {
					this.$message({
						type: "success",
						message: "新增待办事项成功",
					});
					// 向数组的开头添加一个或更多元素，并返回新的长度
					this.todoList.unshift({
						title: value,
						isChecked: false,
					});
				})
				.catch(() => {
					this.$message({
						type: "info",
						message: "取消新增待办事项",
					});
				});
		},
	},
	mounted: function () {
		this.setNowTime();
	},
};
</script>

<style scoped>
/* 引入样式 */
@import "../../assets/css/home.css";
</style>
