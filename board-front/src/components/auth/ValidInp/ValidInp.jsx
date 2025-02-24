/** @jsxImportSource @emotion/react */
import * as s from './style';
import React, { useState } from 'react';

export default function ValidInp({
  type,
  name,
  placeholder,
  value,
  onChange,
  onFocus = null,
  regexp,
  errorMessage,
  inpValidError,
  setInpValidError,
}) {
  // 포커스가 나갔을 때
  const handleOnBlur = (e) => {
    if (value == '') {
      return;
    }

    setInpValidError((prev) => ({
      ...prev,
      [name]: !regexp.test(value),
    }));
  };

  return (
    <div css={s.groupBox}>
      <input
        type={type}
        name={name}
        placeholder={placeholder}
        value={value}
        onChange={onChange}
        onFocus={onFocus}
        onBlur={handleOnBlur}
        css={s.textInp}
      />
      {!!inpValidError[name] && <p css={s.messageTxt}>{errorMessage}</p>}
    </div>
  );
}
