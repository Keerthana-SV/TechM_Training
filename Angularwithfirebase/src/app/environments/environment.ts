import { initializeApp } from "firebase/app";
import { getAnalytics } from "firebase/analytics";

export const environment = {
  production: false,
  firebaseConfig: {
    apiKey: "AIzaSyCPrpC_garufdZtCw4Oa0BSZZXzFGkwSo8",
    authDomain: "chat-app-14e1f.firebaseapp.com",
    projectId: "chat-app-14e1f",
    storageBucket: "chat-app-14e1f.appspot.com",
    messagingSenderId: "105694483175",
    appId: "1:105694483175:web:8ec4525cd9afc6638d4842",
    measurementId: "G-8YHJR3SYXV"
  }
};

// Initialize Firebase
const app = initializeApp(environment.firebaseConfig);
const analytics = getAnalytics(app);
