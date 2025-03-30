import { useEffect, useState } from 'react';
import Route from './Route';

export default function RouterDom({ children }) {
  //  path name 상태값
  // const [pathName, setpathName] = useState(window.location.pathname);

  // window.location.pathname 변경 될 떄마다 path name 셋팅
  // useEffect(() => {
  //   setpathName(window.location.pathname);
  // }, [window.location.pathname]);

  return <div>{children}</div>;
}
