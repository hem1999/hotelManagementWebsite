interface RoomIdsNamesMap {
    [key: string]: string;
  }

export interface Booking{
    bookingId: Number,
    bookingDate: String,
    startDate: String,
    endDate: String,
    roomIdsNamesMap: RoomIdsNamesMap,
    customerId: Number,
    customerName: String

}

// "bookings": {
//         "current": [],
//         "previous": [],
//         "upcoming": [
//             {
//                 "bookingId": 3,
//                 "bookingDate": "2024-08-04T22:30:03.552065",
//                 "startDate": "2024-08-27",
//                 "endDate": "2024-08-29",
//                 "roomIdsNamesMap": {
//                     "1": "Gmu Motel",
//                     "2": "GM Motel"
//                 },
//                 "customerId": 2,
//                 "customerName": "hemanth duddu"
//             }
//         ]
//     }