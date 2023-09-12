import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { Bus } from './bus';

@Injectable({
  providedIn: 'root'
})
export class BusService {

  private baseURL = "http://localhost:8081/api/v1/bus";

  constructor(private httpClient: HttpClient) { }

  getAllBus(): Observable<Bus[]>{
    return this.httpClient.get<Bus[]>(`${this.baseURL}`);
  }

  getBusList(): Observable<Bus[]>{
    return this.httpClient.get<Bus[]>(`${this.baseURL}`);
  }

  saveBusDetails(bus: Bus): Observable<Object>{
    return this.httpClient.post<Bus>(`${this.baseURL}`,bus);
  }

  getBusById(busId: number): Observable<Bus>{
    console.log("i  here");
    return this.httpClient.get<Bus>(`${this.baseURL}/${busId}`);
  }

  updatebusDetailsById(busId: number, bus: Bus): Observable<Object>{
    console.log("i  here");
    
    return this.httpClient.put(`${this.baseURL}/${busId}`,bus);
  }
  /*updatebusDetailsById(busId: number, bus: Bus): Observable<Object>{
    return this.httpClient.put(`${this.baseURL}/updatebus/${busId}`, bus);
  }*/

 
  deleteBusById(busId: number): Observable<Object>{
    console.log("i  here");
    return this.httpClient.delete(`${this.baseURL}/${busId}`);
  }

  deleteAllBuses(): Observable<any> {
    return this.httpClient.delete(`${this.baseURL}`);
  }

  findByACDomain(): Observable<Bus[]> {
    console.log("i  here");
    return this.httpClient.get<Bus[]>(`${this.baseURL}/acBus`);
  }

  findByNonACDomain(): Observable<Bus[]> {
   console.log("i  Non AC here");
    return this.httpClient.get<Bus[]>(`${this.baseURL}/nonACBus`);
  }

  findBytravelerName(travelerName: any):Observable<Bus[]>{
      return this.httpClient.get<Bus[]>(`${this.baseURL}?name=${travelerName}`);
    }
    
    getBusDetailsBySoursecDestiation(source : any, destination:any) :Observable<Bus[]>{
      console.log(source,destination); 
      return this.httpClient.get<Bus[]>(`${this.baseURL}/matchRoutes?source=${source}&destination=${destination}`);
    }


    findByDriverName( driverName:any) :Observable<Bus[]>{
      console.log("here"); 
      return this.httpClient.get<Bus[]>(`${this.baseURL}/searchByDriverName?name=${driverName}`);
    }
    
    sortByCost(pathVar:string,fieldName:String):Observable<Bus[]>{
      console.log('i am here');
      return this.httpClient.get<Bus[]>(`${this.baseURL}/filter/Price/${pathVar}?price=${fieldName}`);
    }
    
    
    sortByRatings(pathVar:string,fieldName:String):Observable<Bus[]>{
      console.log(pathVar,fieldName);
        return this.httpClient.get<Bus[]>(`${this.baseURL}/filter/Rating/${pathVar}?ratings=${fieldName}`);
       }

}
