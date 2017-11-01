let local = {
  save (key, value) {
    localStorage.setItem(key, JSON.stringify(value))
  },
  fetch (key) {
    return JSON.parse(localStorage.getItem(key)) || {}
  },
  saveSession (key, value) {
    sessionStorage.setItem(key, JSON.stringify(value))
  },
  fetchSession (key) {
    return JSON.parse(sessionStorage.getItem(key)) || {}
  },
  clearSession(key){
    sessionStorage.removeItem(key)
  }
}
export default {
  install: function (vm) {
    vm.prototype.$local = local
  }
}
