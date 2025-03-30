import Hello from './Hello/Hello';
import HHH, { printConsole, printConsole2 } from './Hello2/Hello2';
import DataListLayout from './props/DataListLayout/DataListLayout';
import DataListLayout2 from './props/DataListLayout2/DataListLayout2';
import TextInput from './props/TextInput/TextInput';
// import 이름(export default), { 이름(export), 이름(export) } from './Hello2/Hello2';

export default function App() {
  // printConsole();
  // printConsole2();

  return (
    <>
      {/* component */}
      <Hello />
      <HHH />

      {/* props */}
      <TextInput id="name" text="이름" />
      <TextInput id="age" text="나이" />
      <TextInput id="address" text="주소" />
      <TextInput id="gender" text="성별" />

      {/* children */}
      <DataListLayout>
        <li>1 props li</li>
        <li>2 props li</li>
        <li>3 props li</li>
        <li>4 props li</li>
      </DataListLayout>

      <DataListLayout2 dataList={[1, 2, 3, 4, 5]} />
    </>
  );
}
