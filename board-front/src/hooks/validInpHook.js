import { useState } from 'react';

export const useValidInpHook = ({ regexp, errorTxt }) => {
  const [name, setName] = useState('');
  const [value, setValue] = useState('');
  const [errorMsg, setErrorMsg] = useState('');

  const handleOnChange = (e) => {
    setName(e.target.name);
    setValue(e.target.value);
  };

  const handleOnBlur = () => {
    const check = regexp.test(value) ? '' : errorTxt;
    setErrorMsg(check);
  };

  // return { "name" : name, "value" : value, "errorMsg" : errorMsg };
  return { name, value, errorMsg, handleOnChange, handleOnBlur };
};
