<template>
  <div class="region">
    <el-card class="box-card">
      <div slot="header" class="clearfix">
        <span>{{gradeInfoJuniorList.name}}</span>
        <el-button style="float: right; padding: 0px 0" type="text">新增</el-button>
      </div>
      <div v-for="p in gradeInfoJuniorList.grade" v-if="p.status=='1'" :key="p.name" class="text item">
        {{p.name }}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;{{p.gradeName}}<el-button style="float: right; padding: 0px 0" type="text" @click="anniu(p.id)">操作按钮</el-button>
      </div>
    </el-card>
    <el-card class="box-card">
      <div slot="header" class="clearfix">
        <span>{{gradeInfoSeniorList.name}}</span>
        <el-button style="float: right; padding: 0px 0" type="text">新增</el-button>
      </div>
      <div v-for="o in gradeInfoSeniorList.grade" v-if="o.status=='1'" :key="o.name" class="text item">
        {{o.name }}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;{{o.gradeName}}<el-button style="float: right; padding: 0px 0" type="text" @click="anniu(o.id)">操作按钮</el-button>
      </div>
    </el-card>
    <el-dialog
      title="提示"
      :visible.sync="dialogVisible"
      width="30%"
      :before-close="handleClose">
      <span>这是一段信息</span>
      <span slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="dialogVisible = false">确 定</el-button>
      </span>
    </el-dialog>
  </div>
</template>
<script>
  import router from '../../../router/index'
  import $ from 'jquery'
  import {
    URL,
    PHOTO_URL
  } from "../../../../store/mutations_type"
  import local from '../../../lib/session'
  export default {
    created(){
      this.getGradeInfoList();
    },
    data() {
      return {
        dialogVisible: false,
        gradeInfoSeniorList:[],
        gradeInfoJuniorList:[]
      };
    },
    methods:{
      //获取年级信息
      getGradeInfoList(){
        var that=this;
        $.ajax({
          type : 'post',
          url : `${URL}/gradeLevelInfo/list`,
          data : {
            token:this.$local.fetchSession("token").token
          },
          dataType : 'json',
          success : function(msg) {
            console.log(msg);
            if(msg.code==0){
               this.gradeInfoSeniorList = msg.data[1][1];
               this.gradeInfoJuniorList = msg.data[1][0];
            }
          }.bind(this)
        });
      },
      anniu(data){
        alert(data);
        this.dialogVisible = true;
      },
      handleClose(done) {
        this.$confirm('确认关闭？')
          .then(_ => {
            done();
          })
          .catch(_ => {});
      }
    }
  }
</script>
<style>
  .text {
    font-size: 14px;
  }

  .item {
    margin-bottom: 18px;
  }

  .clearfix:before, .clearfix:after {
    display: table;
    content: "";
  }

  .clearfix:after {
    clear: both
  }

  .box-card {
    margin-top: 50px;
    margin-left: 50px;
    width: 480px;
    float: left;
  }
</style>
