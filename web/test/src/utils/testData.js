// LocalStorage keys
export const TOKEN_OBJECT_KEY = "TokenObject";
export const TOKEN_KEY = "Token";
// 站点相关信息
export const webSiteInfo = {
	copyright: "Copyright © 2022 JiangHu. All rights reserved.",
	service: "IT云教学服务",
	serviceUrl: "/education/index",
	icp: "蜀ICP备 2021031966号-1",
	icpUrl: "https://beian.miit.gov.cn/",
	prn: "蜀公网安备 **********号",
	prnUrl: "http://www.beian.gov.cn/portal/index",
};
// 用户信息
export const user = {
	userId: 1,
	userName: "cxk",
	password: "111111",
	birthday: "1980-01-01",
	gender: "female",
	email: "hujiang@163.com",
	userImage: "/images/default.jpg",
	role: "staff",
	address: "四川成都成华区77号",
	profession: "软件工程师",
	webSite: "www.sfac.xyz",
	aboutMe: "也许我这一生都在和自己的普通做抗争，这种抗争也许是徒劳的，但这又怎么样呢？",
	skills: [
		{ name: "Java", percentage: 80 },
		{ name: "Python", percentage: 70 },
		{ name: "DB", percentage: 65 },
		{ name: "JavaScript", percentage: 60 },
		{ name: "Linux", percentage: 40 },
	],
};
// 头部导航
export const navList = [
	{ navUrl: "/education/index", target: "", navTitle: "首页" },
	{ navUrl: "/education/courses", target: "", navTitle: "课程中心" },
	{ navUrl: "/education/notes", target: "", navTitle: "笔记列表" },
	{ navUrl: "/education/papers", target: "", navTitle: "在线考试" },
];

// banner 列表
export const banners = [
	{ src: "/img/banner_01.jpg", url: "/course/1", subject: "课程1" },
	{ src: "/img/banner_02.jpg", url: "/course/2", subject: "课程2" },
	{ src: "/img/banner_03.png", url: "/course/3", subject: "课程3" },
];
// SideBar 测试数据
export const navigationData = [
	{
		title: "系统首页",
		path: "/index",
		icon: "el-icon-setting",
	},
	{
		title: "账户模块",
		path: "/account",
		icon: "el-icon-user-solid",
		subItems: [
			{
				title: "个人主页",
				path: "/account/profile",
			},
			{
				title: "用户列表",
				path: "/account/users",
			},
		],
	},
	{
		title: "测试模块",
		path: "/test",
		icon: "el-icon-s-flag",
		subItems: [
			{
				title: "你好世界1",
				path: "/test/helloWorld1",
			},
			{
				title: "你好世界2",
				path: "/test/helloWorld2",
			},
		],
	},
];

// 主页面板数据
export const starData = [
	[
		{
			icon: "el-icon-service",
			title: "公司总员工数",
			total: 198397,
			bgColor: "#ebcc6f",
		},
		{
			icon: "el-icon-location-outline",
			title: "客户分布区域",
			total: 19,
			bgColor: "#3acaa9",
		},
		{
			icon: "el-icon-star-off",
			title: "收货好评",
			total: 190857,
			bgColor: "#67c4ed",
		},
	],
	[
		{
			icon: "el-icon-edit-outline",
			title: "历史订单数",
			total: 9397,
			bgColor: "#af84cb",
		},
		{
			icon: "el-icon-share",
			title: "产品总转发数量",
			total: 9097,
			bgColor: "#67c4ed",
		},
		{
			icon: "el-icon-goods",
			title: "产品总数",
			total: 397,
			bgColor: "#ebcc6f",
		},
	],
];

// 待做事列表、新闻列表
export const todoList = [],
	latestNewList = [];
for (let i = 0; i < 5; i++) {
	todoList.push({
		title: `待办事项 ` + i,
		isChecked: false,
	});
	latestNewList.push({
		time: new Date(new Date().getTime() + i * 24 * 3600 * 1000).Format("yyyy-MM-dd"),
		title: `今日最新新闻` + i,
	});
}
