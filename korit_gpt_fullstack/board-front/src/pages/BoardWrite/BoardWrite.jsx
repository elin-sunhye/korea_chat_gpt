/** @jsxImportSource @emotion/react */
import * as s from './style';
import React, { useEffect, useRef, useState } from 'react';
import Quill from 'quill';
import 'quill/dist/quill.snow.css';
import Swal from 'sweetalert2';
import { useNavigate, useParams } from 'react-router-dom';
import { useCreateBoardMutation } from '../../mutations/boardMutation';

export default function BoardWrite({}) {
  const navigate = useNavigate();
  const params = useParams();

  const createBoardMutation = useCreateBoardMutation();
  const contaiinerQuillRef = useRef();

  const [quill, setQuill] = useState(null);
  const [quillTitle, setQuillTitle] = useState('');
  const [quillContent, setQuillContent] = useState('');

  useEffect(() => {
    const toolbarOptions = [
      [{ header: [1, 2, 3, 4, 5, 6, false] }],
      [{ font: [] }],
      ['bold', 'italic', 'underline', 'strike'], // toggled buttons
      [{ color: [] }, { background: [] }], // dropdown with defaults from theme
      [{ align: [] }],
      ['link', 'image', 'video', 'formula'],

      // [{ header: 1 }, { header: 2 }], // custom button values
      // [{ script: 'sub' }, { script: 'super' }], // superscript/subscript
      // [{ direction: 'rtl' }], // text direction
      // [{ size: ['small', false, 'large', 'huge'] }], // custom dropdown
      // ['clean'], // remove formatting button
      // ['blockquote', 'code-block'],
      // [{ indent: '-1' }, { indent: '+1' }], // outdent/indent
      // [{ list: 'ordered' }, { list: 'bullet' }, { list: 'check' }],
    ];

    const quill = new Quill(contaiinerQuillRef.current, {
      modules: {
        toolbar: toolbarOptions,
      },
      theme: 'snow',
      placeholder: 'Write, Enter your contents...',
    });

    setQuill(quill);

    quill.on('text-change', () => {
      setQuillContent(quill.root.innerHTML);
    });
  }, []);

  const handleSaveBtnOnClick = async (e) => {
    if (!quillTitle.trim()) {
      await Swal.fire({
        titleText: '제목을 입력하세요.',
        icon: 'error',
        showConfirmButton: true,
        confirmButtonText: '확인',
      });
      return;
    } else if (!quill.root.innerText.trim()) {
      await Swal.fire({
        titleText: '게시글 내용을 입력하세요.',
        icon: 'error',
        showConfirmButton: true,
        confirmButtonText: '확인',
      });
      return;
    }

    const board = {
      title: quillTitle,
      content: quillContent,
      categoryName: params.categoryName,
    };

    const resp = await createBoardMutation.mutateAsync(board);
    await Swal.fire({
      titleText: '게시글 작성 완료',
      showConfirmButton: false,
      timer: 1000,
    });
  };

  return (
    <div css={s.quillEditor}>
      <div css={s.quillTop}>
        <input
          type="text"
          name="title"
          id="quillTitle"
          placeholder="Enter board title"
          value={quillTitle}
          onChange={(e) => {
            setQuillTitle(e.target.value);
          }}
        />
        <button type="button" onClick={handleSaveBtnOnClick} css={s.saveBtn}>
          Save
        </button>
      </div>
      <div ref={contaiinerQuillRef}></div>
    </div>
  );
}
