import React from 'react';

export default function DataListLayout({ children }) {
  // console.log(children);

  const liList = [
    <li>5 props li</li>,
    <li>6 props li</li>,
    <li>7 props li</li>,
    <li>8 props li</li>,
  ];

  return (
    <ul>
      {children}
      {liList}
      {children.map((li, idx) => (
        <li key={`idx` + idx}>{'1' + li.props.children}</li>
      ))}
      {liList.map((li2, idx2) => (
        <li key={`idx2` + idx2}>{'2' + li2.props.children}</li>
      ))}
    </ul>
  );
}
