/**
 * 비동기
 * ; 비동기 프로그래밍은 작업을 병렬적으로 처리하거나 시간이 걸리는 작업을 기다리지 않고 다음 코드를 실행
 *
 * Promise(resolve, reject)
 * ; Promise는 비동기 작업의 성공(resolve)과 실패(reject)를 관리하는 객체
 * then, catch, finally
 * 표현식
  const promise = new Promise((resolve, reject) => {
    const success = true;
    if (success) {
      resolve("Success!");
    } else {
      reject("Failed!");
    }
  });
  // 사용
  promise
    .then(result => console.log(result)) // 성공
    .catch(error => console.error(error)) // 실패
    .finally(() => console.log("Done")); // 항상 실행
 */

export default function App10() {
  setTimeout(() => {
    // console.log('1');
    // console.log('2');

    setTimeout(() => {
      // console.log('3');
    }, 2000);
  }, 3000);

  // Synchronous callback
  function print(print) {
    print();
  }
  // print(() => console.log('Synchronous callback'));

  // Asynchronous callback
  function delayPrint(handler, timeout) {
    setTimeout(handler, timeout);
  }
  // delayPrint(() => console.log('Asynchronous callback'), 3000);

  /**
  Promise ----------
    resolve 결정하다 -> 성공
    reject 거부하다 -> 실패

    - 생성자가 생성이 되면 즉시 살행
  */
  const isSuccess = false;
  const isSuccess2 = true;

  console.log('1');

  const p1 = new Promise((resolve, reject) => {
    console.log('111Create Promise111');

    if (isSuccess) {
      resolve();
    } else {
      reject();
    }
  });
  p1.then(() => {
    console.log('p1.then1');
  }).catch(() => {
    console.log('p1.catch1');
  });

  console.log('2');

  const p2 = new Promise((resolve, reject) => {
    console.log('222Create Promise222');

    if (isSuccess2) {
      resolve();
    } else {
      reject();
    }
  });
  p2.then(() => {
    console.log('p2.then1');
  })
    .then(() => {
      console.log('p2.then2');
    })
    .catch(() => {
      console.log('p2.catch1');
    });

  const p3 = new Promise((resolve, reject) => {
    console.log('333Create Promise333');

    const res = {
      status: 200,
      data: {
        username: 'aaa',
        password: '123',
      },
    };

    if (true) {
      resolve({ res });
    } else {
      reject();
    }
  });
  p3.then((r) => {
    console.log(r);
    if (true) throw new Error('Error!!!');

    return {
      res: {
        ...r.res,
        data: {
          ...r.res.data,
          name: 'ksh',
          email: 'tjsgp1401@gmail.com',
        },
      },
    };
  })
    .then((r) => {
      console.log(r);
    })
    .catch((e) => {
      console.error(e);
    });

  const p4 = new Promise((resolve, reject) => {
    console.log('444Create Promise444');

    const res = {
      status: 400,
      data: {
        errorMassage: '문자열 형식이 맞지 않습니다',
      },
    };

    if (!true) {
      resolve({ res });
    } else {
      reject(new Error(JSON.stringify({ res })));
    }
  });
  p4.catch((e) => {
    console.error(e);
  });

  return <></>;
}
