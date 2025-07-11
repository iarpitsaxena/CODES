const obj1 = {
  name: "Ditin",
  age: 19,
};

const obj2 = {
  name: "Ditin",
  age: 19,
};

const checkObjEquality = (obj1, obj2) => {
  if (Object.keys(obj1).length !== Object.keys(obj2).length) {
    return false;
  }
  for (const key in obj1) {
    if (!obj2.hasOwnProperty(key)) {
      return false;
    }
  }
  for (const key in obj1) {
    if (obj1[key] !== obj2[key]) {
      return false;
    }
  }
  return true;
};

const result = checkObjEquality(obj1, obj2);
console.log(result);
