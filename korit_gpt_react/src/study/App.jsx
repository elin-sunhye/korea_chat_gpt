import Hello from './Hello/Hello';
import HHH, { printConsole, printConsole2 } from './Hello2/Hello2';
// import 이름(export default), { 이름(export), 이름(export) } from './Hello2/Hello2';

export default function App() {
  printConsole();
  printConsole2();
  return (
    <>
      <Hello />
      <HHH />
    </>
  );
}
