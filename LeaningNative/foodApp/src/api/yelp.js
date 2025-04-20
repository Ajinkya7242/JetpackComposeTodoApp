import axios from "axios";

export default axios.create({
  baseURL: "https://api.yelp.com/v3/businesses/",
  headers: {
    Authorization:
      "Bearer sQQxJBszyhuVOxdjqf_9GpMb349XR4MNNQr6lTk8iuXEDsDUhbUC1qax-cvVLJ9T07fbr6qSxI8m7HpDHbcr-8pw5nFkHmL37O2m_kWvKd1IXD_FqElEAWvA8kzHZ3Yx",
  },
});
