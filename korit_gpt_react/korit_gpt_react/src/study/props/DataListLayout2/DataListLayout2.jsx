export default function DataListLayout2({ dataList }) {
  return (
    <ul>
      {dataList.map((li, idx) => (
        <li key={`li` + idx}>{li}</li>
      ))}
    </ul>
  );
}
