import { Route, Routes } from 'react-router-dom';
import WritePage from './pages/WritePage/WritePage';
import IndexPage from './pages/IndexPage/IndexPage';
import { Global } from '@emotion/react';
import { global } from './styles/global';
import MainLayout from './components/MainLayout/MainLayout';

export default function App() {
  return (
    <>
      <Global styles={global} />

      <MainLayout>
        <Routes>
          <Route path="/" element={<IndexPage />} />
          <Route path="/write" element={<WritePage />} />
        </Routes>
      </MainLayout>
    </>
  );
}
