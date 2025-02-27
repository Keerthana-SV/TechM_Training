import react from "react";
import Sunflower from "./Sunflower";
import Iris from "./Iris";
import Lavender from "./Lavender";
import Dahlia from "./Dahlia";
const Lily = () => {
  return (
    <>
      <div>
        <h2>Lily - Nature’s Poetry in Bloom!</h2>
        <p>
          {" "}
          Lilies bloom with elegance and grace, Symbolizing purity, love, and a
          peaceful embrace.
        </p>
      </div>
      <Sunflower />
      <Iris />
      <Lavender />
      <Dahlia/>
    </>
  );
};

export default Lily;
