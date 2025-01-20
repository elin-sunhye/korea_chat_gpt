import ReactDOM from 'react-dom/client';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
// import RouterDom from './components/RouterDom/RouterDom';
// import Route from './components/RouterDom/Route';
import App from './App';

const root = ReactDOM.createRoot(document.getElementById('root'));

root.render(
  // <RouterDom>
  //   <Route path={'/a'} element={<h1>a page</h1>} />
  //   <Route path={'/b'} element={<h1>b page</h1>} />
  //   <Route path={'/c'} element={<h1>c page</h1>} />
  //   <Route path={'/d'} element={<h1>d page</h1>} />
  // </RouterDom>
  <BrowserRouter>
    <App />
  </BrowserRouter>
);
