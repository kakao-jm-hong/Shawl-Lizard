export const baseStore = {
  state: {
    user: {
      token: null,
      nickName: null,
    },
  },
  mutations: {
    setUser(state, user) {
      return state.user = user;
    },
  },
  actions: {
    setUser({commit}, user) {
      commit('setUser', user);
    },
  }
};

export default baseStore;