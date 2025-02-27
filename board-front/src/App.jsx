import { Global } from '@emotion/react';
import { global } from './styles/global';
import Mainlayout from './components/common/Mainlayout/Mainlayout';
import { Route, Routes } from 'react-router-dom';
import AuthRoute from './routes/authRoute/authRoute';
import MainRoute from './routes/mainRoute/mainRoute';
import { useUserMeQuery } from './queries/useUserMeQuery';

function App() {
  useUserMeQuery();

  return (
    <>
      <Global styles={global} />

      <Mainlayout>
        <Routes>
          <Route path="/auth/*" element={<AuthRoute />} />
          <Route path="/*" element={<MainRoute />} />
        </Routes>
      </Mainlayout>
    </>
  );
}

export default App;
