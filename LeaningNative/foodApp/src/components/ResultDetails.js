import React from "react";
import { View, Text, StyleSheet, Image } from "react-native";

const ResultDetails = ({ item }) => {
  return (
    <View>
      <Image source={{ uri: item.image_url }} style={styles.imgRest}  />
      <Text style={styles.textRest} ellipsizeMode="tail" numberOfLines={1}>
        {item.name}
      </Text>
      <Text style={styles.textRating}>{item.rating} Stars , {item.review_count}</Text>
    </View> 
  );
};

const styles = StyleSheet.create({
  imgRest: {
    borderRadius: 8,
    width: 250,
    height: 140,
  },
  textRest: {
    fontSize: 15,
    fontWeight: 500,
    width:150,
    color: "black",
  },
  textRating:{
    color:"grey",
    fontSize:12,
    
  }
});

export default ResultDetails;
