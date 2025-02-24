import { Global } from '@emotion/react';
import { global } from './styles/global';
import Mainlayout from './components/common/Mainlayout/Mainlayout';
import MainContainer from './components/common/MainContainer/MainContainer';
import MainSidebar from './components/common/MainSidebar/MainSidebar';
import Login from './pages/Login/Login';
import Join from './pages/Join/Join';
import { Route, Routes } from 'react-router-dom';

function App() {
  return (
    <>
      <Global styles={global} />
      <Mainlayout>
        <MainSidebar />
        <MainContainer>
          <Routes>
            <Route path="/auth/login" element={<Login />} />
            <Route path="/auth/join" element={<Join />} />
          </Routes>
        </MainContainer>
      </Mainlayout>
    </>
  );
}

export default App;
