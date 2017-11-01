<template>
  <div class="home">
    <div class="home_content">
      <div class="home_top">
        <p>智慧校园管理平台</p>
        <ul>
          <li><img src="../img/logout.png" alt=""><span>退出</span></li>
          <li><span>周老师</span><img src="../img/sort.png" alt=""></li>
        </ul>
      </div>
      <div class="home_left">
        <el-row class="tac">
          <el-col>
            <el-menu
              default-active="2"
              class="el-menu-vertical-demo"
              background-color="rgba(26, 26, 26, 0.3)"
              text-color="#fff"
              router
              active-text-color="rgb(255,255,255)"
              :unique-opened="true"
              >
              <el-submenu v-for="item in sysFunction" :index="item.functionName" :key="item.functionName">
                <template slot="title">
                  <img :src="item.photoPath" alt="">
                  &nbsp;{{item.functionName}}
                </template>
                <el-menu-item-group v-for="itCh in item.children" :key="itCh.functionName">
                  <el-menu-item :index="/home/+itCh.action">
                    {{itCh.functionName}}
                  </el-menu-item>
                </el-menu-item-group>
              </el-submenu>
            </el-menu>
          </el-col>
        </el-row>
      </div>
      <div class="home_right">
        <router-view></router-view>
      </div>
    </div>
  </div>
</template>
<script>
  import router from '../router/index'
  import $ from 'jquery'
  import {
    URL,
    PHOTO_URL
  } from "../../store/mutations_type"
  import local from '../lib/session'
  export default {
    created(){
      this.getFunction();
    },
    data(){
      return{
        sysFunction:[]
      }
    },
    methods: {
      //获取左侧功能列表
      getFunction(){
        var that=this;
        $.ajax({
          type : 'post',
          url : `${URL}/sysFunction/getFunction`,
          data : {
            token:this.$local.fetchSession("token").token
          },
          dataType : 'json',
          success : function(msg) {
            console.log(msg);
            for(var i=0;i<msg.data.length;i++){
              msg.data[i].photoPath=PHOTO_URL+msg.data[i].photoPath
            }
            this.sysFunction = msg.data;
          }.bind(this)
        });
      }
    },

  }
</script>
<style lang="less">
  @import "../../style/home.less";
  @import "../css/home.css";
</style>
































