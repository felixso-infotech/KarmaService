import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { JhiDataUtils } from 'ng-jhipster';

import { IRegisteredUser } from 'app/shared/model/KarmaApp/registered-user.model';

@Component({
  selector: 'jhi-registered-user-detail',
  templateUrl: './registered-user-detail.component.html'
})
export class RegisteredUserDetailComponent implements OnInit {
  registeredUser: IRegisteredUser;

  constructor(private dataUtils: JhiDataUtils, private activatedRoute: ActivatedRoute) {}

  ngOnInit() {
    this.activatedRoute.data.subscribe(({ registeredUser }) => {
      this.registeredUser = registeredUser;
    });
  }

  byteSize(field) {
    return this.dataUtils.byteSize(field);
  }

  openFile(contentType, field) {
    return this.dataUtils.openFile(contentType, field);
  }
  previousState() {
    window.history.back();
  }
}
