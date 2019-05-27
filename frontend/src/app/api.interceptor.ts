import { Injectable } from '@angular/core';
import { HttpEvent, HttpInterceptor, HttpHandler, HttpRequest } from '@angular/common/http';
import {Observable} from 'rxjs';
import {LoginService} from './service/login.service';

@Injectable()
export class TokenInterceptor implements HttpInterceptor {
  constructor(public auth: LoginService) {}
  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    if (this.auth.getToken() !== '' && this.auth.getToken() != null) {
      request = request.clone({
          headers: request.headers.set('Authorization', 'Bearer ' + this.auth.getToken())
        });
    }
    return next.handle(request);  }
}
