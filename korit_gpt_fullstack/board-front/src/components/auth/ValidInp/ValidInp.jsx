/** @jsxImportSource @emotion/react */
import * as s from './style';
import React, { useState } from 'react';

export default function ValidInp({
  type = 'text',
  name = '',
  placeholder = '',
  value,
  onChange = null,
  onFocus = null,
  regexp = null,
  errorMessage = '',
  inpValidError = null,
  setInpValidError = null,
}) {
  // 포커스가 나갔을 때
  const handleOnBlur = (e) => {
    if (!regexp) {
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
      {!!inpValidError && !!inpValidError[name] && (
        <p css={s.messageTxt}>{errorMessage}</p>
      )}
    </div>
  );
}
