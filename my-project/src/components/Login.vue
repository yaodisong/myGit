<template>
  <div class="login">
      <div class="login_content">
        <el-form labelWidth="51px">
          <el-form-item>
            账 号：
            <el-input type="text" v-model="userName" id="userName"></el-input>
          </el-form-item>
          <el-form-item>
            密 码：
            <el-input type="password" v-model="userPassword" @keyup.enter="goHome" id="userPassword" ></el-input>
          </el-form-item>
          <el-form-item>
            <el-checkbox v-model="loginchecked">记住密码？</el-checkbox>
            <el-button @click="goHome">登录</el-button>
          </el-form-item>
        </el-form>
      </div>
    <img class="logo" src="../img/logo.png">
  </div>
</template>

<script>
import router from '../router/index'
import $ from 'jquery'
import {
  URL
} from "../../store/mutations_type"
import Base from "js-base64"
import md5 from "js-md5";
export default {

  data () {
    return {
      userName:'',
      userPassword:'',
      loginchecked:false
    }
  },
  methods:{
    goHome(){
      var that=this;
      $.ajax({
        type : 'post',
        url : `${URL}/access/login`,
        data : {
          userId:this.userName,
          password:md5(this.userPassword)
        },
        dataType : 'json',
        success : function(msg) {
          console.log(msg);
          if(msg.code=="0"){
            //获取session
            this.$local.saveSession("token", {
              token:msg.data.token
            })
            router.push('/Home');
          }
        }.bind(this)
      });
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style lang="less">
  @import "../../style/login.less";

</style>
