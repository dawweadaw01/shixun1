<template>
  <div class="login-wrapper">
    <div class="login-main">
      <h3 class="login-title">SFAC_Admin</h3>
      <el-form :model="user" :rules="rules" ref="userForm">
        <el-form-item prop="userName">
          <el-input v-model="user.userName" placeholder="用户名"></el-input>
        </el-form-item>
        <el-form-item prop="password">
          <el-input
            type="password"
            placeholder="密码"
            v-model="user.password"
          ></el-input>
        </el-form-item>
        <el-form-item>
          <el-button class="login-btn" type="primary" @click="login()"
            >登录</el-button
          >
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script>
export default {
  name: "Login",
  data: function () {
    return {
      user: {
        userName: "cxk",
        password: "111111",
      },
      rules: {
        userName: [
          {
            required: true,
            message: "请输入用户名",
            trigger: ["blur", "change"],
          },
        ],
        password: [
          {
            required: true,
            message: "请输入密码",
            trigger: ["blur", "change"],
          },
        ],
      },
    };
  },
  methods: {
    login: function () {
      this.$refs["userForm"].validate((valid) => {
        if (!valid) {
          this.$message.error("登录表单字段输入格式有误");
          return false;
        }

        this.$Request
          .fetch_("/api/account/login", "post", this.user)
          .then((result) => {
            if (result.code == this.$Request.OK_CODE) {
              // 登录成功后将用户对象设置到状态管理器里面
              this.$VuexStore.commit("setToken", result.data);
              this.$router.push("/");
            } else {
              this.$message.error(result.message);
              return false;
            }
          })
          .catch(() => {});
      });
    },
  },
};
</script>

<style scoped lang="less">
.login-wrapper {
  height: 100%;
  background: #f7f7f7;
}
#canvas {
  width: 100%;
}
.login-main {
  position: absolute;
  top: 50%;
  left: 50%;
  width: 320px;
  height: 370px;
  padding: 20px 35px;
  border: 1px solid #eee;
  margin: -185px 0 0 -160px;
  &::before,
  &::after {
    position: absolute;
    height: 12px;
    content: "";
  }
  &::before {
    left: 4px;
    right: 4px;
    top: -12px;
    z-index: 2;
    background-color: #f5f5f5;
  }
  &::after {
    left: 10px;
    right: 10px;
    top: -22px;
    z-index: 1;
    background-color: #f0f0f0;
  }
}
.login-title {
  padding-bottom: 15px;
  border-bottom: 2px solid #459f75;
  margin: 15px 0 45px 0;
  color: #555;
  text-align: center;
  font-size: 30px;
}
.login-btn {
  width: 100%;
  height: 36px;
  margin-top: 30px;
  font-size: 16px;
}
.login-tip {
  color: #999;
  font-size: 12px;
  line-height: 30px;
}
.login-anim {
  position: absolute;
  bottom: 0;
  left: 0;
  z-index: -1;
}
</style>
