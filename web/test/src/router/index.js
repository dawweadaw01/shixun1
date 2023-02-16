import Vue from "vue";
import Router from "vue-router";

Vue.use(Router);

export default new Router({
	mode: "history", // history 模式去除地址栏 # 号
	routes: [
		{
			// http://127.0.0.1:8081/test/helloworld1
			path: "/test/helloworld1",
			name: "测试页1",
			component: () => import("@/components/test/HelloWorld1.vue"),
			meta: { requireAuth: false },
		},
		{
			// http://127.0.0.1:8081/test/helloworld2
			path: "/test/helloworld2",
			name: "测试页2",
			component: () => import("@/components/test/HelloWorld2.vue"),
			meta: { requireAuth: false },
		},
		// 一级路由，渲染到 App.vue 中的 <router-view />
		// {
		// 	// http://127.0.0.1:8081/
		// 	path: "/",
		// 	name: "主页",
		// 	component: () => import("@/components/Home.vue"),
		// 	meta: { requireAuth: false },
		// },
		// {
		// 	// http://127.0.0.1:8080/#/account
		// 	path: "/account",
		// 	name: "账户模块",
		// 	component: Layout,
		// 	redirect: "/account/profile",
		// 	// 二级路由，渲染到该组件中的 <router-view />
		// 	children: [
		// 		{
		// 			// http://127.0.0.1:8080/#/account/profile
		// 			path: "/account/profile",
		// 			name: "个人主页",
		// 			component: () => import("@/components/account/Profile.vue"),
		// 			meta: { requireAuth: true },
		// 		},
		// 	],
		// },
	],
});
