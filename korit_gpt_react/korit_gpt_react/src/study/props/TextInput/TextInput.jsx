export default function TextInput({ id, text}) {
  const user = {
    username: 'test',
    password: '1234',
    name: 'SUNHYE',
  };

  const { username, name } = user;
  // console.log(username);
  // console.log(name);

  return (
    <div>
      <label className="" htmlFor={id}>
        {text}
      </label>
      <input className="" id={id} type="text" />
    </div>
  );
}
