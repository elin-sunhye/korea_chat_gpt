/** @jsxImportSource @emotion/react */
import axios from 'axios';
import * as s from './style';

import { useEffect, useState } from 'react';
import ReactQuill from 'react-quill';

export default function WritePage() {
  // Quill ------------------------------
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

  // css 적용
  useEffect(() => {
    const head = document.querySelector('head');
    const link = document.createElement('link');
    link.rel = 'stylesheet';
    link.href = 'https://unpkg.com/react-quill@1.3.3/dist/quill.snow.css';
    head.appendChild(link);
  }, []);

  // 작성 데이터 ------------------------------
  const [inpValue, setInpValue] = useState({
    title: '',
    content: '',
  });

  // inp 데이터
  const handleInpOnChange = (e) => {
    setInpValue({
      ...inpValue,
      // title이라고 작성해도 되지만 확장성을 위해 동적 키를 받는다
      [e.target.name]: e.target.value,
    });
  };

  // quill 데이터
  const handleQuillOnChange = (value) => {
    setInpValue({
      ...inpValue,
      content: value,
    });
  };

  // 작성하기 버튼 클릭 이벤트
  const handleWriteSubmitOnClick = async () => {
    console.log(inpValue);
    try {
      const response = await axios.post(
        'http://localhost:8080/servlet_study_war/api/board',
        inpValue
      );
    } catch (e) {}
  };

  return (
    <div>
      <div css={s.headerLayout}>
        <button type="button" onClick={handleWriteSubmitOnClick}>
          작성하기
        </button>
      </div>

      <div css={s.titleLayout}>
        <input
          type="text"
          name="title"
          id="title"
          placeholder="제목을 입력해주세요"
          value={inpValue.title}
          onChange={handleInpOnChange}
        />
      </div>

      <ReactQuill
        modules={{
          toolbar: toolbarOptions,
        }}
        style={{
          boxSizing: 'border-box',
          width: '100%',
          height: '600px',
        }}
        placeholder="내용을 입력해주세요"
        value={inpValue.content}
        onChange={handleQuillOnChange}
      />
    </div>
  );
}
