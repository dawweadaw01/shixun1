import Vue from "vue";
import Router from "vue-router";

Vue.use(Router);

export default new Router({
	mode: "history", // history 模式去除地址栏 # 号
	routes: [
		{
			// http://127.0.0.1:8081/login
			path: "/login",
			name: "登录",
			component: () => import("@/components/account/Login.vue"),
			meta: { requireAuth: false },
		},
		{
			// http://127.0.0.1:8080/
			path: "/",
			name: "Root",
			component: () => import("@/components/Layout.vue"),
			redirect: "/index",
			// 二级路由，渲染到该组件中的 <router-view />
			children: [
				{
					// http://127.0.0.1:8080/index
					path: "/index",
					name: "Dashboard",
					component: () => import("@/components/common/Dashboard.vue"),
					meta: { requireAuth: true },
				},
			],
		},
		{
			// http://127.0.0.1:8080/account
			path: "/account",
			name: "账户模块",
			component: () => import("@/components/Layout.vue"),
			redirect: "/test/users",
			// 二级路由，渲染到该组件中的 <router-view />
			children: [
				{
					// http://127.0.0.1:8080/account/users
					path: "/account/users",
					name: "用户列表",
					component: () => import("@/components/account/Users.vue"),
					meta: { requireAuth: true },
				},
			],
		},
		{
			// http://127.0.0.1:8080/test
			path: "/test",
			name: "测试模块",
			component: () => import("@/components/Layout.vue"),
			redirect: "/test/helloworld1",
			// 二级路由，渲染到该组件中的 <router-view />
			children: [
				{
					// http://127.0.0.1:8080/test/helloworld1
					path: "/test/helloworld1",
					name: "测试1",
					component: () => import("@/components/test/HelloWorld1.vue"),
					meta: { requireAuth: true },
				},
				{
					// http://127.0.0.1:8080/test/helloworld2
					path: "/test/helloworld2",
					name: "测试2",
					component: () => import("@/components/test/HelloWorld2.vue"),
					meta: { requireAuth: true },
				},
			],
		},
	],
});
