import { createAppContainer } from "react-navigation";
import { createStackNavigator } from "react-navigation-stack";
import SearchScreen from "./src/screens/SeachScreen";
import ResultsShowScreen from "./src/screens/ResultsShowScreen";
const navigator = createStackNavigator(
  {
    search: SearchScreen,
    ResultsShowScreen:ResultsShowScreen
  },
  {
    initialRouteName: "search",
    defaultNavigationOptions: {
      title: "Business Search",
    },
  }
);

export default createAppContainer(navigator);
