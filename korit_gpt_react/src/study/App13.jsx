import axios from 'axios';

export default function App13() {
  const handleRequestOnClick = async () => {
    let response = null;

    try {
      response = await axios.get(
        'http://localhost:8080/servlet_study_war/api/user'
      );
      console.log('response', response);
      console.log('data', response.data.username);
    } catch (e) {
      console.error('e', e);
    }
  };

  /**
   * BookRestServlet (/api/book)
   * - get 요청
   *    BookId, bookName, author, publisher, category, imgUrl
   */
  const handleBookRequestOnClick = async () => {
    let resp = null;

    try {
      resp = await axios.get(
        'http://localhost:8080/servlet_study_war/api/book'
      );

      console.log('resp', resp);
    } catch (e) {
      console.error(e); 
    }
  };
  return (
    <div>
      <button type="button" onClick={handleRequestOnClick}>
        요청
      </button>

      <button type="button" onClick={handleBookRequestOnClick}>
        도서 요청
      </button>
    </div>
  );
}
