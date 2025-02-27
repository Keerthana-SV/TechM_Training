import { StrictMode } from "react";
import { createRoot } from "react-dom/client";
import "./index.css";
import C1 from "./C1";
ReactDOM.createRoot(document.getElementById("root")).render(
  <React.StrictMode>
    <C1 />
  </React.StrictMode>
);
