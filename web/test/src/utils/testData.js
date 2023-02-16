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
	userName: "jiangHu",
	birthday: "1980-01-01",
	gender: "female",
	email: "hujiang@163.com",
	userImage: "/img/default_big.jpg",
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
