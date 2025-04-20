import React from "react";
import {
  View,
  Text,
  StyleSheet,
  FlatList,
  Image,
  TouchableOpacity,
} from "react-native";

import { withNavigation } from "react-navigation";
import ResultDetails from "../components/ResultDetails";

const ResultsList = ({ title, results, navigation }) => {
  return (
    <View style={styles.mainView}>
      <Text style={styles.titleText}>{title}</Text>

      <FlatList
        horizontal
        data={results}
        showsHorizontalScrollIndicator={false}
        keyExtractor={(results) => results.id}
        style={styles.flatListImg}
        renderItem={({ item }) => {
          return (
            <View style={styles.restaurantView}>
              <TouchableOpacity
              onPress={()=>navigation.navigate('ResultsShowScreen',{id:item.id})}>
                <ResultDetails item={item} />
              </TouchableOpacity>
            </View>
          );
        }}
      ></FlatList>
    </View>
  );
};

const styles = StyleSheet.create({
  mainView: {
    marginHorizontal: 10,
    marginVertical: 3,
  },
  titleText: {
    fontSize: 18,
    color: "black",
    fontWeight: "600",
  },
  flatListImg: {
    marginTop: 4,
  },
  restaurantView: {
    marginHorizontal: 3,
    width: 250,
  },
});

export default withNavigation(ResultsList);
