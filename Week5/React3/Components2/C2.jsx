import React, { Suspense } from "react";
import C5 from "@f2/C5";  // Use alias instead of relative path
const C4 = React.lazy(() => import("@f2/C4"));
const C3 = React.lazy(() => import("./C3"));

const C2 = () => {
  return (
    <div>
      <h1>This is Component C2!!!</h1>

      <Suspense fallback={<h3>Loading C3...</h3>}>
        <C3 />
      </Suspense>

      <Suspense fallback={<h3>Loading C4...</h3>}>
        <C4 />
      </Suspense>

      <C5 />
    </div>
  );
};

export default C2;
