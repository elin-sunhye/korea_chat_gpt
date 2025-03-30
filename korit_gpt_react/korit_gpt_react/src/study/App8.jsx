import { useState } from 'react';
import { useRef } from 'react';

/**
 * useRef()
 */
export default function App8() {
  // useRef ----------
  const aRef = useRef(null);
  const bRef = useRef(null);
  const cRef = useRef(null);
  const dRef = useRef(null);

  // useState ----------
  const [inpRefs, setInpRefs] = useState([aRef, bRef, cRef, dRef]);

  // handle ----------
  const handleOnKeyDown = (e, idx) => {
    if (e.key !== 'Enter') {
      return;
    }

    if (idx + 1 === inpRefs.length) {
      inpRefs[0].current.focus();
    } else {
      inpRefs[idx + 1].current.focus();
    }

    // let nextIdx = 0;

    // for (let i = 0; i < inpRefs.length; i++) {
    //   if (inpRefs[i].current === e.target) {
    //     nextIdx = i + 1;
    //     break;
    //   }
    // }

    // nextIdx = nextIdx === inpRefs.length ? 0 : nextIdx;

    // inpRefs[nextIdx].current.focus();
  };

  return (
    <>
      {inpRefs.map((ref, idx) => (
        <input
          type="text"
          ref={ref}
          onKeyDown={(e) => {
            handleOnKeyDown(e, idx);
          }}
        />
      ))}
      {/* 
      <input type="text" ref={aRef} onKeyDown={handleOnKeyDown} />
      <input type="text" ref={bRef} onKeyDown={handleOnKeyDown} />
      <input type="text" ref={cRef} onKeyDown={handleOnKeyDown} />
      <input type="text" ref={dRef} onKeyDown={handleOnKeyDown} /> */}
    </>
  );
}
