import { StrictMode } from "react";
import { createRoot } from "react-dom/client";
import "./index.css";
//import App from "./App.jsx";
//import Lavender from "./assets/FlowerShop/Lavender.jsx";
import Lily from "./assets/FlowerShop/Lily.jsx";

/*createRoot(document.getElementById("root")).render(
  <StrictMode>
    <App />
  </StrictMode>
);*/
createRoot(document.getElementById("root")).render(
  <StrictMode>
      <Lily />
  </StrictMode>
);
