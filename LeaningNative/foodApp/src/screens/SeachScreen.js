import React, { useState, useEffect } from "react";
import { Text, StyleSheet, View, ScrollView } from "react-native";
import SearchBar from "../components/SearchBar";
import useResults from "../hooks/useResults";
import ResultsList from "../components/ResultsList";

const SearchScreen = ({navigation}) => {
  const [term, setTerm] = useState("");
  const [searchApi, results, errorMsg] = useResults();

  const filterPriceResults = (price) => {
    return results.filter((result) => {
      return result.price === price;
    });
  };
  console.log(results);
  return (
    <View style={{ flex: 1 }}>

      <SearchBar
        term={term}
        onTermChanged={(newTerm) => {
          setTerm(newTerm);
        }}
        onTermSubmitted={() => {
          searchApi(term);
        }}
      />
      <ScrollView style={{marginVertical:15}}>
        <ResultsList title="Cost Effective" results={filterPriceResults("$")} />
        <ResultsList title="Bit Pricier" results={filterPriceResults("$$")} />
        <ResultsList title="Bit Spender" results={filterPriceResults("$$$")} />
        <ResultsList title="Most Expender" results={filterPriceResults("$$$$")} />
      </ScrollView>
    </View>
  );
};

const styles = StyleSheet.create({});

export default SearchScreen;
