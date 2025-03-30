export default function Route({ path, element }) {
  return <>{window.location.pathname === path && element}</>;
}
