package service;

import regRes.EventResponse;
import regRes.EventRequest;
import dao.EventDao;
import dao.AuthenticationDao;
import models.Event;
import models.Authentication;

public class EventService {

  /**
   * The Handler will call this to try and get an event or all events from the DB
   * @param request
   * @return a EventResponse Object
   */
  public EventResponse event(EventRequest request){
    EventDao dao = new EventDao();
    AuthenticationDao authDao = new AuthenticationDao();
    Authentication auth = null;
    EventResponse response = null;
    boolean success = false;
    try {
      auth = authDao.getAuthentication(request.getAuthToken());

      if (auth == null){
        response = new EventResponse();
        response.setMessage("Invalid auth token");
        return response;
      }

      if (request.getId() != null){
        Event event = dao.getEvent(request.getId());
        if (!event.getDescendant().equals(auth.getUserName())){
          response = new EventResponse();
          response.setMessage("Requested event does not belong to this user");
          return response;
        }
        response = new EventResponse(event);
      } else {
        Event[] events = dao.getAllEvents();
        response = new EventResponse(events);
      }
    }
    catch(Exception e){
      System.out.println("Error: " + e.getMessage());
      e.printStackTrace();
    }
    return response;
  }
}
