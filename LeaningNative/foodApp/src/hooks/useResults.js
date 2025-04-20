import { useEffect, useState } from "react";
import yelp from "../api/yelp";

export default () => {
  const [results, setResults] = useState([]);
  const [errorMsg, setErrorMsg] = useState("");

  const searchApi = async (searchTerm) => {
    console.log(searchTerm);
    try {
      const response = await yelp.get("search", {
        params: {
          limit: 50,
          searchTerm,
          location: "san jose",
        },
      });
      setResults(response.data.businesses);
    } catch (err) {
      console.log(err);
      setErrorMsg("Somthing went wrong");
    }
  };

  useEffect(() => {
    searchApi("food");
  }, []);

  return [searchApi, results, errorMsg];
};
