/** @jsxImportSource @emotion/react */
import * as s from './style';

import { useEffect } from 'react';
import ReactQuill from 'react-quill';

export default function WritePage() {
  const toolbarOptions = [
    ['bold', 'italic', 'underline', 'strike'], // toggled buttons
    ['blockquote', 'code-block'],
    ['link', 'image', 'video', 'formula'],

    [{ header: 1 }, { header: 2 }], // custom button values
    [{ list: 'ordered' }, { list: 'bullet' }, { list: 'check' }],
    [{ script: 'sub' }, { script: 'super' }], // superscript/subscript
    [{ indent: '-1' }, { indent: '+1' }], // outdent/indent
    [{ direction: 'rtl' }], // text direction

    [{ size: ['small', false, 'large', 'huge'] }], // custom dropdown
    [{ header: [1, 2, 3, 4, 5, 6, false] }],

    [{ color: [] }, { background: [] }], // dropdown with defaults from theme
    [{ font: [] }],
    [{ align: [] }],

    ['clean'], // remove formatting button
  ];

  useEffect(() => {
    const head = document.querySelector('head');
    const link = document.createElement('link');
    link.rel = 'stylesheet';
    link.href = 'https://unpkg.com/react-quill@1.3.3/dist/quill.snow.css';
    head.appendChild(link);
  }, []);

  return (
    <div>
      <div css={s.headerLayout}>
        <button type="button">작성하기</button>
      </div>
      <ReactQuill
        modules={{
          toolbar: toolbarOptions,
        }}
      />
    </div>
  );
}
