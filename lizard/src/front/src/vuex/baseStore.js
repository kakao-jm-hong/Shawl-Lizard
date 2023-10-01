export const baseStore = {
  state: {
      token: null,
      nickName: 'HongJeongMin',
      image: ''
  },
  mutations: {
    setToken(state, token) {
      return state.token = token;
    },
    setNickName(state, nickName) {
      return state.nickName = nickName;
    },
    setImage(state, image) {
      return state.image = image;
    },
  },
  actions: {

  },
  getters: {
    isLogin(state) {
      console.info(state.token);
      return state.token != null && state.token !='';
    }
  }
};

export default baseStore;