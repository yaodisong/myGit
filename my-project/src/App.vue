<template>
  <div id="app">
    <router-view/>
  </div>
</template>

<script>
export default {
  name: 'app'
}
</script>

<style>
  *{
    margin: 0px;
    padding: 0px;
    list-style: none;
    text-decoration: none;
    font-family: ﻿MicrosoftYaHei;
    font-size: 14px;
    font-weight: normal;
    font-style: normal;
    font-stretch: normal;
  }
  html,body{
    width: 100%;
    height: 100%;
  }
  #app{
    width: 100%;
    height: 100%;
    min-width: 1300px;min-height: 850px
  }
</style>
