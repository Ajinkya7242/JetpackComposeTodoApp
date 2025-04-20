import React from "react";
import { StyleSheet, Text, View, TextInput } from "react-native";
import Feather from "@expo/vector-icons/Feather";

const SearchBar = ({term,onTermChanged,onTermSubmitted}) => {
  return (
    <View style={styles.inputOutline}>
      <Feather
        name="search"
        size={26}
        style={{
          color: "grey",
        }}
        color="black"
      />
      <TextInput
        style={styles.inputStyle}
        placeholder="Search"
        autoCapitalize="none"
        autoCorrect={false}
        value={term}
        onChangeText={(newTerm) => {
          onTermChanged(newTerm);
        }}
        onEndEditing={()=>{
            onTermSubmitted()
        }}
      >
       
      </TextInput>
    </View>
  );
};

const styles = StyleSheet.create({
  inputOutline: {
    backgroundColor: "#e8e8e8",
    borderRadius: 10,
    height: 49,
    marginHorizontal: 15,
    marginTop: 15,
    paddingLeft: 10,
    flexDirection: "row",
    alignItems: "center",
  },
  inputStyle: {
    flex: 1,
    paddingLeft: 10,
    fontWeight: "400",
    fontSize: 18,
    color: "black",
  },
});

export default SearchBar;
